import * as React from 'react';

import {wizardPages as pages} from "./OrderWizard"
import {NextButton} from "./NextButton";
import {BackButton} from "./BackButton";
import PaymentPanel from "./PaymentPanel";
import {connect} from "react-redux";

export class WhichPayment extends React.PureComponent {

	state = {
		redirect: false,
		face2face: true,
		online: false
	}

	onFace2faceChanged = (e) => {
		this.setState({
			face2face: e.currentTarget.value === 'face2face',
			online:false
		});
	}

	onOnlineChanged = (e) => {
		this.setState({
			online: e.currentTarget.value === 'online',
			face2face: false
		});
	}

	render() {
		return (
			<div style={{display: "flex"}} className="wizardPanel">
				<BackButton page={pages.ADDRESS}/>
				<div className="wizardInner">
					<div>
						<h2>How do you wish to pay?</h2>
					</div>
					<div>
						<input type="radio"
									 id="contactChoice2"
									 name="pickupOrDelivery"
									 value="face2face"
									 checked={this.state.face2face}
									 onChange={this.onFace2faceChanged}
						/>

						<label htmlFor="contactChoice2">Pay on arrival</label>

						<input type="radio"
									 id="contactChoice1"
									 name="pickupOrDelivery"
									 value="online"
									 checked={this.state.online}
									 onChange={this.onOnlineChanged}

						/>
						<label htmlFor="contactChoice1">Online</label>
					</div>

					{this.state.online && !this.state.face2face &&
					<div>
						<PaymentPanel/>
					</div>}
				</div>
				<NextButton label={"NEXT"} page={pages.SUMMARY}/>
			</div>
		);
	}
}


const mapDispatchToProps = dispatch => {
	return {
		updateAddress: (value, id) => {
			alert("here  " + value)
			// dispatch(createUpdatePayment(value, id));
		},
	};
};

export default connect(
	null,
	mapDispatchToProps,
)(WhichPayment);

// export default WhichPayment;