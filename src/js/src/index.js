import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {Provider} from "react-redux";

import { createStore, applyMiddleware, compose } from 'redux';
import createSagaMiddleware from 'redux-saga';

import {combineReducers} from 'redux';
import {reducer as login} from './reducers/loginReducer';

let cr =  combineReducers({
	login,
});

const sagaMiddleware = createSagaMiddleware();

//for redux plugin
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(cr, composeEnhancers(applyMiddleware(sagaMiddleware)));

ReactDOM.render(
	<Provider store={store}>
		<App/>,
	</Provider>,
document.getElementById('root')
);


