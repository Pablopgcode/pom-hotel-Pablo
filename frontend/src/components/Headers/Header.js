import React from "react";
import { Container } from "reactstrap";

const Header = (props) => {
  
  return (
    <>
      <div className="page-header clear-filter" filter-color="black">
        <div
            className="page-header-image" style={{ backgroundImage: "url(" + props.image + ")", backgroundSize: "cover"}}>           
        </div>
        <Container>
          <div className="content-center brand">
            <h2 className="h1-seo">by ZDevs</h2>
            <h3>Find emotions</h3>
          </div>
          <h6 className="category category-absolute">
            Designed by{"Pablo"}
          </h6>
        </Container>    
      </div>
    </>
  );
}

export default Header;
