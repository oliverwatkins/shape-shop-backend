import * as React from 'react';

import "./../main.scss"

import ItemBox from "./ItemBox";
import {createFetchProductsAction, createUpdateProductSelection} from "../products/productActions";
import {connect} from "react-redux";

export class ProductSelection extends React.PureComponent {
	render() {

		let items = this.props.products.items;

		return (
			<div>
				<div className="product-selection">
					{
						items && items.map((e) => (
							<ItemBox product={e} handleQ={this.props.updateProductSelection}/>
							)
						)
					}
				</div>
			</div>
		);
	}
}

const mapDispatchToProps = dispatch => {
	return {
		updateProductSelection: (value, id) => {
			dispatch(createUpdateProductSelection(value, id));
		},
	};
};

export default connect(
	null,
	mapDispatchToProps,
)(ProductSelection);

