import * as React from 'react';
import ProductsPanel from "./ProductsPanel";
import {createFetchProductsAction} from "./products/productActions";
import connect from "react-redux/es/connect/connect";

import weeCard from './assets/img/welcome.jpg';


export class Overview extends React.PureComponent {
	render() {

		console.info("this.props.products " + JSON.stringify(this.props.products))

		// this.props.products

		return (
			<div>
				<img className="wee-card__img" src={weeCard} alt="Wee Card" />
				<ProductsPanel items={this.props.products.items}/>
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
)(Overview);
// export default Overview;
