import React, { Component }  from 'react';


class OfferPopup extends React.Component {
    constructor() {
      super();
      this.state = {
        isOpen: false
      };                  // state to control the state of popup
    }
  
    handleOpen = () => {
      this.setState({ isOpen: true });
    }
  
    handleClose = () => {
      this.setState({ isOpen: false });
    }
  
    render() {
      return (
        <div>
          <Popup
            trigger={<button>click to open</button>}
            content={<button onClick={this.handleClose}>click to close</button>}
            on='click'
            open={this.state.isOpen}
            onOpen={this.handleOpen}
          />
        </div>
      );
    }
  }

  export default OfferPopup