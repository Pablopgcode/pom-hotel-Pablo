import React from "react";
// reactstrap components
import { Container } from "reactstrap";

const Header = (props) => {
  let pageHeader = React.createRef();

  React.useEffect(() => {
    if (window.innerWidth > 991) {
      const updateScroll = () => {
        let windowScrollTop = window.pageYOffset / 3;
        pageHeader.current.style.transform =
          "translate3d(0," + windowScrollTop + "px,0)";
      };
      window.addEventListener("scroll", updateScroll);
      return function cleanup() {
        window.removeEventListener("scroll", updateScroll);
      };
    }
  });

  return (
    <>
      <div className="page-header clear-filter" filter-color="black">
        <div
            className="page-header-image" style={{ backgroundImage: "url(" + props.image + ")", backgroundSize: "cover"}} ref={pageHeader}>           
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
