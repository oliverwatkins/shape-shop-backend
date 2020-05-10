import * as React from 'react';
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleLeft} from "@fortawesome/free-solid-svg-icons";
import OrderSummary from "./OrderSummary";
import {NextButton} from "./NextButton";
import {wizardPages as pages} from "./OrderWizard";
import AddressSummary from "./AddressSummary";
import type {Address} from "../AppState";
import PaymentSummary from "./PaymentSummary";
import {BackButton} from "./BackButton";


type Props = {
	selectedProducts: [],
	address: Address
}


export class Summary<Props> extends React.PureComponent {
	render() {
		return (
			<div style={{display: "flex"}} className="wizardPanel">

				<BackButton page={"/order/address??"}/>

				<div className={"wizardInner"}>
					<h2>Summary</h2>

					<h3>Order</h3>

					<OrderSummary selectedProducts={this.props.selectedProducts}/>

					<h3>Delivery Address</h3>

					<AddressSummary address={this.props.address}/>

					<h3>Payment</h3>

					<PaymentSummary/>

					{/*{JSON.stringify(this.props.address)}*/}
				</div>
				<NextButton label={"OK"} page={pages.ADDRESS_}/>
			</div>
		);
	}
}

export default Summary;
