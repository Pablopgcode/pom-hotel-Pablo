import React from "react";
import '../assets/css/various-ui-comp.css'

const Testimony = (props) => {  
    
    return(
        <div className="item">
            <div className="testimony text-center">
                <span className="img-user" style={{ backgroundImage: "url(" + props.person + ")", backgroundSize: "cover"}}></span>
                <span className="user">{props.user}</span>
                <small>{props.city}</small>
                <blockquote>
                    <p>{props.coment}</p>
                </blockquote>
            </div>
        </div>
    )
};

export default Testimony;