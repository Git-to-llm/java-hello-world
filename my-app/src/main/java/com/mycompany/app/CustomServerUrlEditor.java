func NewRecordReplayClient(ctx context.Context, t *testing.T, rf func(r *httprep
 			t.Fatal(err)
 		}
 		rf(rec)
		c, err = rec.Client(ctx, opts...)
		if err != nil {
			t.Fatal(err)
		}
 		cleanup = func() {
 			if err := rec.Close(); err != nil {
 				t.Fatal(err)
 			}
 		}
 
		return c, cleanup, state.UnixNano()
 	}
 	t.Logf("Replaying from golden file %s", path)
 	rep, err := httpreplay.NewReplayer(path)
 	if err != nil {
 		t.Fatal(err)
 	}
	c, err = rep.Client(ctx)
	if err != nil {
		t.Fatal(err)
	}
 	recState := new(time.Time)
 	if err := recState.UnmarshalBinary(rep.Initial()); err != nil {
 		t.Fatal(err)
 	}
	return c, func() { rep.Close() }, recState.UnixNano()
 }
 
 // NewAWSSession creates a new session for testing against AWS.