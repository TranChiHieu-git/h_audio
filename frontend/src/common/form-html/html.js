import React from "react";

export const renderInputHtml = ({
                                    input,
                                    placeholder,
                                    meta: {touched, error, warning}
                                }) => (
    <div className="form-group">
        <div>
            <input
                {...input}
                placeholder={placeholder}
            />
        </div>
        {touched && ((error && <span className="error">{error}</span>) || (warning &&
            <span className="warning">{warning}</span>))}
    </div>
);
