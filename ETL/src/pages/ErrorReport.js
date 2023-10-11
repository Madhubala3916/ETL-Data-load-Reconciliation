import React, { useState, useEffect } from "react";
import axios from "axios";
import { Document, Page, pdfjs } from "react-pdf";

pdfjs.GlobalWorkerOptions.workerSrc = `//cdnjs.cloudflare.com/ajax/libs/pdf.js/${pdfjs.version}/pdf.worker.min.js`;

const ErrorReport = () => {
  const [errors, setErrors] = useState([]);
  const [searchQuery, setSearchQuery] = useState("");
  const [filteredErrors, setFilteredErrors] = useState([]);
  const [pdfUrl, setPdfUrl] = useState("");
  const [numPages, setNumPages] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios
      .get("/pdf/errorReport", { responseType: "blob" })
      .then((response) => {
        const pdfBlob = new Blob([response.data], { type: "application/pdf" });
        const url = URL.createObjectURL(pdfBlob);
        setPdfUrl(url);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching PDF:", error);
        setLoading(false);
        setPdfUrl(null); // Clear the URL
      });
      
  }, []);

  const onDocumentLoadSuccess = ({ numPages }) => {
    setNumPages(numPages);
  };

  return (
    <div className="container card-container card p-3">
      <h2 className="text-center mb-4 text-primary">Error Details</h2>
      <div className="mb-3">
        <input
          type="text"
          className="form-control"
          placeholder="Search by Error ID, Error Message, or Entity Name"
          value={searchQuery}
          onChange={(e) => setSearchQuery(e.target.value)}
        />
      </div>
      <div className="card-body">
        {loading ? (
          <p>Loading PDF...</p>
        ) : pdfUrl ? (
          <div>
            <Document file={pdfUrl} onLoadSuccess={onDocumentLoadSuccess}>
              {Array.from(new Array(numPages), (el, index) => (
                <Page key={`page_${index + 1}`} pageNumber={index + 1} />
              ))}
            </Document>
          </div>
        ) : (
          <p>Failed to load PDF.</p>
        )}
      </div>
    </div>
  );
};

export default ErrorReport;
