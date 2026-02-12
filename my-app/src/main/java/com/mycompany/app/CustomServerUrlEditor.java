@@ -115,7 +115,7 @@ func AccountStateAtHeight(sr protocol.StateReader, encodedAddr string, height ui
 	}
 	pkHash := hash.BytesToHash160(addr.Bytes())
 	var account state.Account
	if _, err := sr.State(&account, protocol.BlockHeightOption(height), protocol.LegacyKeyOption(pkHash)); err != nil {
 		if errors.Cause(err) == state.ErrStateNotExist {
 			account = state.EmptyAccount()
 			return &account, nil