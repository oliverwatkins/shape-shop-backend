import {fork} from 'redux-saga/effects';
import login from '../login/LoginSaga';
import initApi from './init';
import api from './api';

const baseApi = initApi();

let weeapi = {
	...api.create(baseApi),
};

/**
 * Single entry point to start all Sagas at once. '$FlowFixMe' is added
 * to suppress Flow warnings. It does not know how to handle generators that well.
 */
export default function* root() {
	yield fork(login(weeapi).loginWatcher);
}
