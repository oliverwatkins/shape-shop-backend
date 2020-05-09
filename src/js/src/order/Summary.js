import * as React from 'react';
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleLeft, faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";
import OrderSummary from "./OrderSummary";
import {NextButton} from "./NextButton";
import {wizardPages as pages} from "./OrderWizard";


type Props = {
	selectedProducts: [],
	address: {}
}



export class Summary<Props> extends React.PureComponent {
	render() {
		return (
			<div style={{display:"flex"}} className="wizardPanel">

				<Link to="/order/address??">
					<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize:"100px", color:"gray"}} />
				</Link>

				<div style={{width:"100%", height:"100%", background:"white"}}>
					<h2>Summary</h2>

					<OrderSummary selectedProducts={this.props.selectedProducts}/>
					<div>Address</div>

					{JSON.stringify(this.props.address)}

					<div>Payment Type</div>

				</div>
				<NextButton label={"OK"} page={pages.ADDRESS_}/>
			</div>
		);
	}
}

export default Summary;
