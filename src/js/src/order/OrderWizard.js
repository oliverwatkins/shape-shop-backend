import * as React from 'react';
import ProductList from "./ProductList";
import connect from "react-redux/es/connect/connect";
import {selectSelectedProducts} from "../selectors";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import {MainNav} from "../MainNav";
import AdminScreen from "../AdminScreen";
import Address from "./Address";
import Payment from "./Payment";
import Summary from "./Summary";
import LoginScreen from "../login/LoginScreen";
import Welcome from "../WelcomeScreen";


export class OrderWizard extends React.PureComponent {
	render() {
		return (
			<div className={"order-wizard"}>
				<Router>
						<Switch>
							<Route path="/order/productlist">
								<ProductList products={this.props.products} selectedProducts={this.props.selectedProducts}/>
							</Route>
							<Route path="/order/address">
								<Address/>
							</Route>
							<Route path="/order/payment">
								<Payment/>
							</Route>
							<Route path="/order/summary">
								<Summary products={this.props.products} selectedProducts={this.props.selectedProducts}/>
							</Route>
						</Switch>
				</Router>
			</div>
		);
	}
}

const mapStateToProps = state => {
	return {
		products: state.products,
		selectedProducts: selectSelectedProducts(state)
	};
};


export default connect(
	mapStateToProps,
	null,
)(OrderWizard);