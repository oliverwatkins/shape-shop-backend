import * as React from 'react';
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleLeft, faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";


export class Payment extends React.PureComponent {
	render() {
		return (
			<div style={{display:"flex"}} className="wizardPanel">

				<Link to="/order/address">
					<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize:"100px", color:"gray"}} />
				</Link>



				<div style={{width:"100%", height:"100%", background:"white"}}>

					<div>Payment</div>

					<div>Cash</div>

					<div>
						Credit card

					</div>
					<div>
					</div>

				</div>



				<div className={"aside"}>
					<Link to="/order/summary">
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize:"100px", color:"gray"}} />
					</Link>
				</div>
			</div>
		);
	}
}

export default Payment;
