import * as typeAction from "../../constant/action";

export const account = (state = null, action) => {
    const {type, value} = action;
    switch (type) {
        case typeAction.ACCOUNT:
            return value ? {...value} : {...state};
        default:
            return {...state};
    }
}
