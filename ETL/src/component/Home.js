import React, { useEffect } from "react";
import { Link, Element, Events, animateScroll as scroll, scrollSpy, scroller } from "react-scroll";
import '../styles/Navbar.css';

const Home = () => {

  return (
    <>
      <div
        id="carouselBasicExample"
        className="carousel slide carousel-fade"
        data-bs-ride="carousel"
      >
        {/* Indicators */}
        <ol className="carousel-indicators">
          <li
            data-bs-target="#carouselBasicExample"
            data-bs-slide-to="0"
            className="active"
          ></li>
          <li data-bs-target="#carouselBasicExample" data-bs-slide-to="1"></li>
          <li data-bs-target="#carouselBasicExample" data-bs-slide-to="2"></li>
        </ol>

        {/* Inner */}
        <div className="carousel-inner">
          {/* First slide */}
          <div className="carousel-item active">
            <img
              src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(15).webp"
              className="d-block w-100"
              alt="Sunset Over the City"
            />
            <div className="carousel-caption d-none d-md-block">
              <h5>First slide label</h5>
              <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
            </div>
          </div>

          {/* Second slide */}
          <div className="carousel-item">
            <img
              src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(22).webp"
              className="d-block w-100"
              alt="Canyon at Night"
            />
            <div className="carousel-caption d-none d-md-block">
              <h5>Second slide label</h5>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
              </p>
            </div>
          </div>

          {/* Third slide */}
          <div className="carousel-item">
            <img
              src="https://mdbcdn.b-cdn.net/img/Photos/Slides/img%20(23).webp"
              className="d-block w-100"
              alt="Cliff Above a Stormy Sea"
            />
            <div className="carousel-caption d-none d-md-block">
              <h5>Third slide label</h5>
              <p>
                Praesent commodo cursus magna, vel scelerisque nisl consectetur.
              </p>
            </div>
          </div>
        </div>

        {/* Controls */}
        <a
          className="carousel-control-prev"
          href="#carouselBasicExample"
          role="button"
          data-bs-slide="prev"
        >
          <span
            className="carousel-control-prev-icon"
            aria-hidden="true"
          ></span>
          <span className="visually-hidden">Previous</span>
        </a>
        <a
          className="carousel-control-next"
          href="#carouselBasicExample"
          role="button"
          data-bs-slide="next"
        >
          <span
            className="carousel-control-next-icon"
            aria-hidden="true"
          ></span>
          <span className="visually-hidden">Next</span>
        </a>
      </div>

      {/* Content below the carousel */}
      <div id="contact" className="position-absolute top-50 start-0 translate-middle-y ps-5 ms-5 w-50">
        <h1 className="fs-1 text-uppercase text-primary">
          ETL Data Reconciliation
        </h1>
        <p>
          <h3>"You're in good hands with us."</h3>
        </p>
      </div>
    </>
  );
};

export default Home;
