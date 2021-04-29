import {combineReducers} from "redux";
import {account} from "./account";

export const core = combineReducers({
    account: account
});
