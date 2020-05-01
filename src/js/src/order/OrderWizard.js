import * as React from 'react';
import {Route, Switch} from "react-router-dom";
import AdminScreen from "../AdminScreen";
import Payment from "./Payment";
import ProductList from "./ProductList";
import Summary from "./Summary";
import connect from "react-redux/es/connect/connect";
import {Overview} from "../WelcomeScreen";


export class OrderWizard extends React.PureComponent {
	render() {
		return (
			<div className={"order-wizard"}>
				order wizard.
				<Switch>
					<Route path="/order/productlist">
						<ProductList products={this.props.products}/>
					</Route>
					<Route path="/order/summary">
						<Summary/>
					</Route>
					<Route path="/order/payment">
						<Payment/>
					</Route>
				</Switch>

				<div className={"aside"}>
					Bestellung

					<button>NEXT</button>

				</div>

			</div>
		);
	}
}

const mapStateToProps = state => {
	return {
		products: state.products,
	};
};


export default connect(
	mapStateToProps,
	null,
)(OrderWizard);


// export default OrderWizard;