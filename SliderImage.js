import React from "react";
import { useState } from "react";
import ArrowBackIosIcon from "@mui/icons-material/ArrowBackIos";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";
import "./SliderImage.css";
export default function SliderImage() {
   const sliderImages = [ 
      {
         url: "https://images.pexels.com/photos/5668473/pexels-photo-5668473.jpeg?cs=srgb&dl=pexels-sora-shimazaki-5668473.jpg&fm=jpg",
      },
      {
         url: "https://img.freepik.com/free-vector/antique-auction-isometric-composition_1284-22062.jpg?size=626&ext=jpg",
      },
      {
         url: "https://img.freepik.com/free-vector/bid-design-background_52683-76080.jpg?size=626&ext=jpg",
      },
      
   ];
   const [activeImageNum, setCurrent] = useState(0);
   const length = sliderImages.length;
   const nextSlide = () => {
      setCurrent(activeImageNum === length - 1 ? 0 : activeImageNum + 1);
   };
   const prevSlide = () => {
      setCurrent(activeImageNum === 0 ? length - 1 : activeImageNum - 1);
   };
   if (!Array.isArray(sliderImages) || sliderImages.length <= 0) {
      return null;
   }
   return (
      <div> <center>
         
         <h2>GRIPPY ONLINE AUCTION APP</h2>
         <section className = "image-slider">
            <div class = "left">
               <ArrowBackIosIcon onClick = {prevSlide} />
            </div>
            <div class="right"> 
               <ArrowForwardIosIcon onClick = {nextSlide} />
            </div>
            {sliderImages.map((currentSlide, ind) => {
               return (
                  <div
                     className={ind === activeImageNum ? "currentSlide active" : "currentSlide"}
                     key={ind}
                  >
                     {ind === activeImageNum && <img src={currentSlide.url} className="image" />}
                  </div>
               );
            })}
         </section></center>
      </div>
   );
}