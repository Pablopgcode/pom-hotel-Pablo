import React, { Component }  from 'react';
import UncontrolledTooltip from 'react';

class OfferPopup extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        message: this.props.discountMsg
      };                
    }
  
    render() {
      return (
        <div>
          <UncontrolledTooltip target="#navbar-brand">
            {this.state.message}
          </UncontrolledTooltip>
        </div>
      );
    }
  }

  export default OfferPopup