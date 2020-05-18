import * as React from 'react';
import ProductList from "./ProductListStep";
import {connect} from "react-redux";
import {selectSelectedProducts} from "../selectors";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import Address from "./AddressStep";
import Summary from "./SummaryStep";
import WhichPayment from "./WhichPaymentStep";
import OKStep from "./OKStep";
import type {AppState, Product} from "../AppState";

//navigation links
export const wizardPages = {
	PRODUCT_LIST : "/order/productlist",
	ADDRESS : "/order/address",
	WHICH_PAYMENT : "/order/whichPayment",
	PAYMENT : "/order/payment",
	SUMMARY : "/order/summary",
	OK: "/order/OK"
}

type Props = {
	products: Array<Product>,
	selectedProducts: Array<Product>,
	address: Address,
	deliveryType: string,
}

export class OrderWizard extends React.PureComponent<Props> {
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
								<Summary
									products={this.props.products}
								 	selectedProducts={this.props.selectedProducts}
								 	address={this.props.address}
									deliveryType={this.props.deliveryType}
								/>
							</Route>
							<Route path={wizardPages.OK}>
								<OKStep/>
							</Route>
						</Switch>
				</Router>
			</div>
		);
	}
}

const mapStateToProps = (state: AppState) => {
	return {
		products: state.products,
		address: state.order && state.order.address,
		selectedProducts: selectSelectedProducts(state),
		deliveryType: state.order && state.order.deliveryType,
		paymentType: state.order && state.order.paymentType,
	};
};


export default connect(
	mapStateToProps,
	null,
)(OrderWizard);