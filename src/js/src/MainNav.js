import React from 'react';

import {Link} from "react-router-dom";

export class MainNav extends React.PureComponent {

	render() {
		return (
			<nav className={"main-nav"}>
				<ul>
					<li>
						<Link to="/">Home</Link>
					</li>
					<li>
						<Link to="/order/productlist">Order</Link>
					</li>
					<li>
						<Link to="/login">ADMIN</Link>
					</li>
				</ul>
			</nav>
		);
	}
}


