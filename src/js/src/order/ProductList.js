import * as React from 'react';
import ProductSelection from "./ProductSelection";
import SideSummary from "./SideSummary";
import {Link} from "react-router-dom";


//redundant
export class ProductList extends React.PureComponent {
	render() {
		return (
			<div style={{display:"flex"}}>
				<ProductSelection  products={this.props.products}/>
				<div className={"aside"}>
					<SideSummary selectedProducts={this.props.selectedProducts}/>
					<Link to="/welcome">NEXT!</Link>
				</div>
			</div>

		);
	}
}

export default ProductList;
