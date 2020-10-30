import React from "react";
import '../assets/css/various-ui-comp.css'

const Space = (props) => {  
    
    return(
        <a className="space-entry animate-box">
           <div className="tour-img" style={{ backgroundImage: "url(" + props.image + ")", backgroundSize: "cover"}}></div>
            <span className="desc">
			    <p className="star">
                    <span>
                        <i className="icon-star-full"></i>
                        <i className="icon-star-full"></i>
                        <i className="icon-star-full"></i>
                        <i className="icon-star-full"></i>
                        <i className="icon-star-full"></i>
                    </span>{props.views}
                </p>
			    <h2>{props.message1}</h2>
			    <span className="desc-spaces">{props.message2}</span>
			    <span className="price">{props.price}</span>
			</span>
        </a>
    )
};

export default Space;

