import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {Provider} from "react-redux";

import { createStore, applyMiddleware, compose } from 'redux';
import createSagaMiddleware from 'redux-saga';
import reducers from './reducers';

// export const persistConfig = {
// 	key: sessionKey,
// 	storage,
// 	whitelist: ['login', 'countriesList', 'languageList', 'i18n', 'customer', 'merchant', 'myArea'],
// };

const sagaMiddleware = createSagaMiddleware();

//for redux plugin
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const store = createStore(reducers, composeEnhancers(applyMiddleware(sagaMiddleware)));

ReactDOM.render(
	<Provider store={store}>
		<App/>,
	</Provider>,
document.getElementById('root')
);


