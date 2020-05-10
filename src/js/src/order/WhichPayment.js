import * as React from 'react';

import {wizardPages as pages} from "./OrderWizard"
import {NextButton} from "./NextButton";
import {BackButton} from "./BackButton";

export class WhichPayment extends React.PureComponent {

	render() {
		return (
			<div style={{display: "flex"}} className="wizardPanel">
				<BackButton page={pages.ADDRESS}/>
				<div className="wizardInner">
					<div>
						<h2>How do you wish to pay?</h2>
					</div>
					<div>
						<input type="radio" id="contactChoice2"
									 name="pckupOrDelivery" value="delivery"/>
						<label htmlFor="contactChoice2" checked>Pay on arrival</label>

						<input type="radio" id="contactChoice1"
									 name="pckupOrDelivery" value="pickup" />
						<label htmlFor="contactChoice1">Online</label>
					</div>
				</div>
				<NextButton label={"NEXT"} page={pages.SUMMARY}/>
			</div>
		);
	}
}
export default WhichPayment;