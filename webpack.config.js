/**
 * The purpose of this file is to add settings to the webpack.
 * Webpack compiles the Vue files to a big JavaScript file
 * and can find lang="ts" in script tags and compile the TypeScript to JavaScript too.
 */
var path = require("path");

module.exports = {
    watch: true,
    devtool: "source-map",
    /**
     * The entry point for our TypeScript, where we start the application
     */
    entry: {
    },
    /**
     * Where to output the compiled bundle JavaScript file
     */
    output: {
        path: path.join(__dirname, "/modules/web/site/src/main/resources/websites/site/cdn/build/"),
        filename: "[name]Bundle.js"
    },
    module: {
        rules: [
            /**
             * Looking for lang="ts" in vue files and
             * compiling them to JavaScript with ts-loader (an npm package)
             */
            {
                test: /\.ts$/,
                exclude: /node_modules|vue\/src/,
                loader: "ts-loader",
                options: {
                    appendTsSuffixTo: [/\.vue$/]
                }
            },
            /**
             * Looking for .vue endings and
             * compiling them to JavaScript with vue-loader (an npm package)
             */
            {
                test: /\.vue$/,
                loader: "vue-loader",
                options: {
                }
            }
        ]
    },
    /**
     * Which extensions that webpack should be looking for and which kind of vue to compile
     */
    resolve: {
        extensions: [".ts", ".js", ".vue", ".json"],
        alias: {
            "vue$": "vue/dist/vue.esm.js"
        }
    },
    node: {
        fs: "empty"
    }
};