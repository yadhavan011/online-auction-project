import React from "react";
import ReactCardSlider from "react-card-slider-component";
import './Slider.css';

const slides = [

  
  {
    image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbWlmcKhNRa4G8v1aryyWb5X_vyGXBKxugjQ&usqp=CAU",
    title: "Dining Table ",
    description: "9000"
  },
  {
    image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpVtmnTzGFZ-sj_nRBU331Wk9HmhiqeypFtg&usqp=CAU",
    title: "Home Decor Statue ",
    description: "9000"
  },
  {
    image: "https://www.khwaahish.com/wp-content/uploads/2021/12/KNA828.jpg",
    title: "Handmade Jewellery",
    description: "12000"
  }
  
];

const Slider = () => {
  return (<center>
    <div className="slider-container" style={{ marginTop: "5em" }}>
      <ReactCardSlider slides={slides}>
        {slides.map((slide, index) => (
          <center><div className="slider-item" key={index}>
            <img src={slide.image} alt={slide.title} />
            <h3>{slide.title}</h3>
            <p>{slide.description}</p>
          </div></center>
        ))}
      </ReactCardSlider>
    </div></center>
  );
};

export default Slider;
