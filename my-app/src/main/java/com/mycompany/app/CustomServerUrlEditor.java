@@ -1192,15 +1192,16 @@ type BlockServer interface {
 	// If this returns a BServerErrorOverQuota, with Throttled=false,
 	// the caller can treat it as informational and otherwise ignore
 	// the error.
	Put(ctx context.Context, tlfID tlf.ID, id kbfsblock.ID, context kbfsblock.Context,
 		buf []byte, serverHalf kbfscrypto.BlockCryptKeyServerHalf) error
		
 	// AddBlockReference adds a new reference to the given block,
	// defined by the given context (which should contain a non-zero
	// BlockRefNonce).  (Contexts with a BlockRefNonce of zero should
	// be used when putting the block for the first time via Put().)
	// Returns a BServerErrorBlockNonExistent if id is unknown within
	// this folder.
 	//
 	// AddBlockReference should be idempotent, although it should
 	// also return an error if, for a given ID and refnonce, any


