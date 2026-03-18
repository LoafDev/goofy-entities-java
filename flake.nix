{
  description = "goofy-entities flake.nix";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/master";
  };

  outputs = { nixpkgs, ... }:
  let
    system = "x86_64-linux";
    pkgs = nixpkgs.legacyPackages.${system};
  in {
    devShells.${system}.default = pkgs.mkShell {
      nativeBuildInputs = with pkgs; [
        javaPackages.compiler.openjdk21
        google-java-format
        # jetbrains.idea
        jdt-language-server
        yt-dlp
      ];

      LD_LIBRARY_PATH = pkgs.lib.makeLibraryPath [ pkgs.libglvnd ];
    };
  };
}

