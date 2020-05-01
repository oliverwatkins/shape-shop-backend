import * as React from 'react';
import ProductList from "./ProductList";


import "./../main.scss"




import welcome from './../assets/img/pizza.png';



export class ProductSelection extends React.PureComponent {
	render() {


		let items = this.props.products.items;

		return (
			<div>
				ProductSelection
				<div className="product-selection">
					{/*<div>*/}
					{
						items && items.map((e) => (
								<div>
									<img className="wee-card__img" src={welcome} alt="Wee Card" width={90}/>
									<div>
										<div>{e.name}</div>
										<div><b> € {e.price}</b></div>
									</div>
									<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike"/>

									<select id="qty">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
									</select>
								</div>
							)
						)
					}
					{/*</div>*/}
				</div>
				{/*products={this.props.products}*/}
			</div>
		);
	}
}

export default ProductSelection;
