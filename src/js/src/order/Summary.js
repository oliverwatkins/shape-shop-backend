import * as React from 'react';
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleLeft, faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";
import OrderSummary from "./OrderSummary";


export class Summary extends React.PureComponent {
	render() {
		return (
			<div style={{display:"flex"}} className="wizardPanel">

				<Link to="/order/address??">
					<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize:"100px", color:"gray"}} />
				</Link>

				<div style={{width:"100%", height:"100%", background:"white"}}>
					<div>Summary</div>

					<OrderSummary selectedProducts={this.props.selectedProducts}/>
					<div>Address</div>

				</div>
				<div className={"aside"}>
					<Link to="???">
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize:"100px", color:"gray"}} />
					</Link>
				</div>
			</div>
		);
	}
}

export default Summary;
