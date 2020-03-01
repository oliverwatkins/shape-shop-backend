import React from 'react';
import './App.css';
import {
	BrowserRouter as Router,
	Switch,
	Route,
	Link
} from "react-router-dom";
import Welcome from "./Welcome";
import Admin from "./Admin";
import User from "./User";

function App() {
  return (
    <div className="App">
			<Router>
				<div>
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
						</ul>
					</nav>
					<Switch>
						<Route path="/admin">
							<Admin />
						</Route>
						<Route path="/user">
							<User />
						</Route>
						<Route path="/">
							<Welcome />
						</Route>
					</Switch>
				</div>
			</Router>
    </div>
  );
}

export default App;
