import {combineReducers} from "redux";
import {reducer as formReducer} from 'redux-form'
import {core} from "./core/index";

export const rootReducer = combineReducers({
    form: formReducer,
    core: core
});
