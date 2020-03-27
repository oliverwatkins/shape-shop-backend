import { fork } from 'redux-saga/effects';
import initApi from '../api/init';
import accountApi from '../api/account';
import uploadApi from '../api/upload';
import shopApi from '../api/shop';

import api from '../api/api';
import WEEAPI_MOCK from '../__mock__/api/Api_mock';
import { MOCK_MODE } from './../featureFlags';
import login from './LoginSaga';
import logout from './LogoutSaga';
import validateCard from '../components/registration/sagas/ValidateCardSaga';
import validateDetails from '../components/registration/sagas/ValidateDetailsSaga';
import confirm from '../components/registration/sagas/ConfirmationSaga';
import CategoriesSaga from '../components/registration/sagas/CategoriesSaga';
import CountriesList from './CountriesListSaga';
import Language from './LanguageSaga';
import Customer from './CustomerSaga';
import TransactionDataSaga from '../components/myArea/sagas/TransactionDataSaga';
import CustomerCashback from './CustomerCashbackSaga';
import UpdateAccountData from '../components/settings/sagas/UpdateAccountData';
import UpdateUserEmail from '../components/settings/sagas/UpdateUserEmail';
import UpdatePaymentData from '../components/settings/sagas/UpdatePaymentData';
import UpdatePaymentSecurity from '../components/settings/sagas/UpdatePaymentSecurity';
import DataCompletenessSaga from '../components/myArea/sagas/DataCompletenessSaga';
import UpdateCashbackRateSaga from '../components/shops/sagas/UpdateCashbackRateSaga';
import MerchantSaga from './MerchantSaga';
import UpdateTransactionLimit from '../components/settings/sagas/UpdateTransactionLimit';
import UpdatePassword from '../components/settings/sagas/UpdatePassword';
import UpdateCompanyData from '../components/settings/sagas/UpdateCompanyData';
import UpdatePaymentDataMerchant from '../components/settings/sagas/UpdatePaymentDataMerchant';
import GetShopsSaga from '../components/shops/sagas/GetShopsSaga';
import UpdateShopSettingsSaga from '../components/shops/sagas/UpdateShopSettingsSaga';
import UploadLogoSaga from '../components/shops/sagas/UploadLogoSaga';
import GetShopTransactionsSaga from '../components/shops/sagas/GetShopTransactionsSaga';
// import type { WeeApi } from '../api/Api.flow';

//let weeapi: WeeApi;
let weeapi;
if (MOCK_MODE) {
	weeapi = WEEAPI_MOCK.create();
} else {
	const baseApi = initApi();
	weeapi = {
		...api.create(baseApi),
		...accountApi.create(baseApi),
		...uploadApi.create(baseApi),
		...shopApi.create(baseApi),
	};
}
/**
 * Single entry point to start all Sagas at once. '$FlowFixMe' is added
 * to suppress Flow warnings. It does not know how to handle generators that well.
 */
//$FlowFixMe
export default function* root() {
	yield fork(login(weeapi).loginWatcher);
	yield fork(logout(weeapi).logoutWatcher);
	yield fork(validateCard(weeapi).cardValidationWatcher);
	yield fork(validateDetails(weeapi).detailsValidationWatcher);
	yield fork(confirm(weeapi).registrationConfirmationWatcher);
	yield fork(CountriesList(weeapi).countriesListWatcher);
	yield fork(CategoriesSaga(weeapi).categoriesListWatcher);
	yield fork(Language(weeapi).languageWatcher);
	yield fork(Customer(weeapi).customerDetailsWatcher);
	yield fork(TransactionDataSaga(weeapi).transactionDataWatcher);
	yield fork(CustomerCashback(weeapi).customerCashbackWatcher);
	yield fork(UpdateAccountData(weeapi).updateAccountDataWatcher);
	yield fork(UpdateUserEmail(weeapi).updateUserEmailWatcher);
	yield fork(UpdatePaymentData(weeapi).updatePaymentDataWatcher);
	yield fork(UpdatePaymentDataMerchant(weeapi).updatePaymentDataMerchantWatcher);
	yield fork(UpdatePaymentSecurity(weeapi).updatePaymentSecurityWatcher);
	yield fork(DataCompletenessSaga(weeapi).dataCompletenessWatcher);
	yield fork(UpdateCashbackRateSaga(weeapi).updateCashbackRateWatcher);
	yield fork(MerchantSaga(weeapi).merchantDetailsWatcher);
	yield fork(UpdateTransactionLimit(weeapi).updateTransactionLimitWatcher);
	yield fork(UpdateTransactionLimit(weeapi).updateTransactionLimitWatcher);
	yield fork(UpdatePassword(weeapi).updatePasswordWatcher);
	yield fork(UpdateCompanyData(weeapi).updateCompanyDataWatcher);
	yield fork(GetShopsSaga(weeapi).getShopsWatcher);
	yield fork(UpdateShopSettingsSaga(weeapi).updateShopSettingsWatcher);
	yield fork(GetShopTransactionsSaga(weeapi).getShopTransactionsWatcher);
	yield fork(UploadLogoSaga(weeapi).uploadLogoWatcher);
}
