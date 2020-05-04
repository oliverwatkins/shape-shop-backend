import * as React from 'react';
import ProductSelection from "./ProductSelection";


export class ProductList extends React.PureComponent {
	render() {
		return (
			<div>
				<ProductSelection  products={this.props.products}/>
			</div>
		);
	}
}

export default ProductList;
