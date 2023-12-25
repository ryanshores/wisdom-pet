import { AppDispatch, RootState } from "./store";
import { TypedUseSelectorHook } from "react-redux";
export declare const useAppDispatch: () => AppDispatch;
export declare const useAppSelector: TypedUseSelectorHook<RootState>;
