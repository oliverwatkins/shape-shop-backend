import * as React from 'react';
import {Link, Route, Switch} from "react-router-dom";
import Payment from "./Payment";
import ProductList from "./ProductList";
import Summary from "./Summary";
import connect from "react-redux/es/connect/connect";
import {selectSelectedProducts} from "../selectors";
import SideSummary from "./SideSummary";


export class OrderWizard extends React.PureComponent {
	render() {
		return (
			<div className={"order-wizard"}>
				<Switch>
					<Route path="/order/productlist">
						<ProductList products={this.props.products} selectedProducts={this.props.selectedProducts}/>
					</Route>
					<Route path="/order/summary">
						<Summary/>
					</Route>
					<Route path="/order/payment">
						<Payment/>
					</Route>
				</Switch>

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