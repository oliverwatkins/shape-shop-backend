import * as React from 'react';
import {Link, Route, Switch} from "react-router-dom";
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
						<Link to="/welcome">NEXT!</Link>


					<span className="ico ico--md ico--home">XX</span>

					<span className="fas fa-camera">cc</span>

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