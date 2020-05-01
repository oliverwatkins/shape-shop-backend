import * as React from 'react';
import {Route, Switch} from "react-router-dom";
import AdminScreen from "../AdminScreen";
import Payment from "./Payment";
import ProductList from "./ProductList";
import Summary from "./Summary";


export class OrderWizard extends React.PureComponent {
	render() {
		return (
			<div>
				order wizard.
				<Switch>
					<Route path="/order/productlist">
						<ProductList/>
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
export default OrderWizard;