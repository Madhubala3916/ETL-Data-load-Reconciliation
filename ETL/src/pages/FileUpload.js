import React, { useState } from "react";

const FileUpload = () => {
  const [file, setFile] = useState(null);
  const [uploadMessage, setUploadMessage] = useState("");

  const handleFileInputChange = (e) => {
    const selectedFile = e.target.files[0];
    setFile(selectedFile);
  };

  const handleFileUpload = async () => {
    if (!file) {
      setUploadMessage("Please select a file to upload.");
      return;
    }

    const formData = new FormData();
    formData.append("file", file);
 console.log(formData.get('file'));
    const jwtToken = localStorage.getItem("jwtToken"); // Retrieve the JWT token from localStorage

    try {
      const response = await fetch("http://localhost:8282/api/csv/upload", {
        method: "POST",
        headers: {
          Authorization: `Bearer ${jwtToken}`,
        },
        body: formData,
      });

      if (response.ok) {
        const data = await response.json();
        setUploadMessage("File uploaded successfully.");
        console.log(data);
      } else {
        setUploadMessage("File upload failed.");
      }
    } catch (error) {
      console.error("Error during file upload:", error);
      setUploadMessage("An error occurred during file upload.");
    }
  };

  return (
    <div className="vh-100 d-flex justify-content-center align-items-center">
      <div
        className="col-md-4 p-5 shadow-sm border rounded-3 bg-light"
        style={{ marginTop: "50px" }}
      >
        <div className="card-body">
          <form>
            <h2 className="card-title text-center fs-2 fw-800 text-uppercase text-primary mb-4">
              File Upload
            </h2>
            <div className="mb-3">
              <input
                type="file"
                className="form-control"
                onChange={handleFileInputChange}
              />
            </div>
            <div className="d-grid">
              <button
                type="button"
                className="btn btn-primary"
                onClick={handleFileUpload}
              >
                Upload
              </button>
            </div>
            <p className="text-center mt-3">{uploadMessage}</p>
          </form>
        </div>
      </div>
    </div>
  );
};

export default FileUpload;
