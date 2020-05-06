import * as React from 'react';
import ProductSelection from "./ProductSelection";
import OrderSummary from "./OrderSummary";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";


type Props = {
	products:[],
	selectedProducts:[],
}

//redundant
export class ProductList extends React.PureComponent<Props> {
	render() {
		return (
			<div style={{display: "flex"}} className="wizardPanel">
				<ProductSelection products={this.props.products}/>
				<div className={"aside"}>

					<OrderSummary selectedProducts={this.props.selectedProducts}/>

					<Link to="/order/address">
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize: "100px", color: "gray"}}/>
					</Link>
				</div>
			</div>
		);
	}
}

export default ProductList;
