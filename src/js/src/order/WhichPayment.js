import * as React from 'react';
import {Link} from "react-router-dom";

import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

import {faArrowCircleLeft, faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";


export class WhichPayment extends React.PureComponent {




	render() {

		let l = "/order/summary"

		return (
			<div style={{display: "flex"}} className="wizardPanel">

				<button>
				<Link to="/order/address">
					<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize: "100px", color: "gray"}}/>
				</Link>
				</button>
				<h2>How do you wish to pay?</h2>
				<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"/>
					<label htmlFor="vehicle1"> Online?</label><br/>


					<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"/>
						<label htmlFor="vehicle1"> Pay on arrival?</label><br/>

					<button>
					<Link to={l}>
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>
					</Link>
					</button>
			</div>
		);
	}
}

export default WhichPayment;
