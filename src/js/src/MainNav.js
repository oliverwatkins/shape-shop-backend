import React from 'react';

import {Link} from "react-router-dom";

export class MainNav extends React.PureComponent {

	render() {
		return (
			<nav>
				<ul>
					<li>
						<Link to="/">Home</Link>
					</li>
					<li>
						<Link to="/admin">Admin</Link>
					</li>
					<li>
						<Link to="/user">Users</Link>
					</li>
					<li>
						<Link to="/login">LOGIN</Link>
					</li>
				</ul>
			</nav>
		);
	}
}


