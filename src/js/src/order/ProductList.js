import * as React from 'react';
import ProductSelection from "./ProductSelection";
import SideSummary from "./SideSummary";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";


//redundant
export class ProductList extends React.PureComponent {
	render() {
		return (
			<div style={{display: "flex"}}>
				<ProductSelection products={this.props.products}/>
				<div className={"aside"}>
					<SideSummary selectedProducts={this.props.selectedProducts}/>
					<Link to="/order/address">
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>
					</Link>
				</div>
			</div>
		);
	}
}

export default ProductList;
