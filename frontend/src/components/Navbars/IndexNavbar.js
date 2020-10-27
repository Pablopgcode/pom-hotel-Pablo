import React from "react";
import { Link } from "react-router-dom";
import '../../assets/css/various-ui-comp.css'

// reactstrap components
import {
  Button,
  Collapse,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  UncontrolledDropdown,
  NavbarBrand,
  Navbar,
  NavItem,
  NavLink,
  Nav,
  Container,
  UncontrolledTooltip,
} from "reactstrap";

function IndexNavbar() {
  const [navbarColor, setNavbarColor] = React.useState("navbar-transparent");
  //const [navbarColor, setNavbarColor] = React.useState("");
  const [collapseOpen, setCollapseOpen] = React.useState(false);
  React.useEffect(() => {
    const updateNavbarColor = () => {
      if (
        document.documentElement.scrollTop > 30 ||
        document.body.scrollTop > 30
      ) {
        setNavbarColor("");
      } else if (
        document.documentElement.scrollTop < 400 ||
        document.body.scrollTop < 400
      ) {
         setNavbarColor("navbar-transparent");
        //setNavbarColor("");
      }
    };
    window.addEventListener("scroll", updateNavbarColor);
    return function cleanup() {
      window.removeEventListener("scroll", updateNavbarColor);
    };
  });
  return (
    <>
      {collapseOpen ? (
        <div
          id="bodyClick"
          onClick={() => {
            document.documentElement.classList.toggle("nav-open");
            setCollapseOpen(false);
          }}
        />
      ) : null}
      <Navbar className={"fixed-top " + navbarColor} expand="lg" color="#011f48">
        <Container>
          <div className="navbar-translate">
            <NavbarBrand
              href="home"
              target="_blank"
              id="navbar-brand">
              <span>POM Hotel & Spa</span>
            </NavbarBrand>
          </div>
          <Collapse
            className="justify-content-end" isOpen={collapseOpen} navbar>
            <Nav navbar>
              <NavItem>
                <NavLink href="/home">
                  <i className="now-ui-icons arrows-1_refresh-69"></i>
                  <span>Home</span>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="/rooms">
                  <i className="now-ui-icons shopping_shop"></i>
                  <span>Rooms</span>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink
                  href="/about">
                  <i className="now-ui-icons design-2_html5"></i>
                  <span>About us</span>
                </NavLink>
              </NavItem>
              <NavItem>
                <NavLink
                  href="/about">
                  <i className="now-ui-icons objects_key-25"></i>
                  <span>Login</span>
                </NavLink>
              </NavItem>
            </Nav>
          </Collapse>
        </Container>
      </Navbar>
    </>
  );
}

export default IndexNavbar;
