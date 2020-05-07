import * as React from 'react';
import {Link} from "react-router-dom";

import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

import {faArrowCircleLeft, faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";

import {wizardPages as pages} from "./OrderWizard"

export class WhichPayment extends React.PureComponent {


	render() {
		return (
			<div style={{display: "flex"}} className="wizardPanel">

				<button>
					<Link to={pages.ADDRESS}>
						<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize: "100px", color: "gray"}}/>
					</Link>
				</button>
				<div>
				<h2>How do you wish to pay?</h2>
				</div>

				<div>
					<div>
						<label htmlFor="postcode">Online?</label>
						<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"/>
					</div>
					<div>
						<label htmlFor="postcode">Pay on arrival?</label>
						<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"/>
					</div>
				</div>


				<button>
					<Link to={pages.SUMMARY}>
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>
					</Link>
				</button>
			</div>
		);
	}
}

export default WhichPayment;
