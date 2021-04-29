export const required = value => (value || typeof value === 'number' ? undefined : 'Vui lòng không để trống.');
