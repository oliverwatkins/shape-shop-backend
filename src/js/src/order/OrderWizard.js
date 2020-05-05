import * as React from 'react';
import ProductList from "./ProductList";
import connect from "react-redux/es/connect/connect";
import {selectSelectedProducts} from "../selectors";


export class OrderWizard extends React.PureComponent {
	render() {
		return (
			<div className={"order-wizard"}>
				<ProductList products={this.props.products} selectedProducts={this.props.selectedProducts}/>
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