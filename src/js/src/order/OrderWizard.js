import * as React from 'react';
import ProductList from "./ProductListStep";
import {connect} from "react-redux";
import {selectSelectedProducts} from "../selectors";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Address from "./AddressStep";
import Summary from "./SummaryStep";
import WhichPayment from "./WhichPaymentStep";

//navigation links
export const wizardPages = {
	PRODUCT_LIST : "/order/productlist",
	ADDRESS : "/order/address",
	WHICH_PAYMENT : "/order/whichPayment",
	PAYMENT : "/order/payment",
	SUMMARY : "/order/summary"
}

export class OrderWizard extends React.PureComponent {
	render() {
		return (
			<div className={"order-wizard"}>
				<Router>
						<Switch>
							<Route path={wizardPages.PRODUCT_LIST}>
								<ProductList products={this.props.products} selectedProducts={this.props.selectedProducts}/>
							</Route>
							<Route path={wizardPages.ADDRESS}>
								<Address/>
							</Route>
							<Route path={wizardPages.WHICH_PAYMENT}>
								<WhichPayment/>
							</Route>
							<Route path={wizardPages.SUMMARY}>
								<Summary products={this.props.products} selectedProducts={this.props.selectedProducts} address={this.props.address}/>
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
		address: state.order && state.order.address,
		selectedProducts: selectSelectedProducts(state)
	};
};


export default connect(
	mapStateToProps,
	null,
)(OrderWizard);