func NewRecordReplayClient(ctx context.Context, t *testing.T, rf func(r *httprep
 			t.Fatal(err)
 		}
 		rf(rec)
 		cleanup = func() {
 			if err := rec.Close(); err != nil {
 				t.Fatal(err)
 			}
 		}
 
		return rec.Client(), cleanup, state.UnixNano()
 	}
 	t.Logf("Replaying from golden file %s", path)
 	rep, err := httpreplay.NewReplayer(path)
 	if err != nil {
 		t.Fatal(err)
 	}
 	recState := new(time.Time)
 	if err := recState.UnmarshalBinary(rep.Initial()); err != nil {
 		t.Fatal(err)
 	}
	return rep.Client(), func() { rep.Close() }, recState.UnixNano()
 }
 
 // NewAWSSession creates a new session for testing against AWS.