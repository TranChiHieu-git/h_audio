import * as typeAction from "../../constant/action";

export const account = (value) => {
    return {
        type: typeAction.ACCOUNT,
        value
    }
}
